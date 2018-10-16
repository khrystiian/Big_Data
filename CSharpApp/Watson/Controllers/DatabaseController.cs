using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Diagnostics;
using System.Globalization;
using MongoDB.Bson;
using MongoDB.Driver;
using Watson.Model;

namespace Watson.Controllers
{
    public class DatabaseController : IDatabaseController
    {
        private readonly string _connectionString;


        public DatabaseController()
        {
            _connectionString = ConfigurationManager.ConnectionStrings["DBString"].ConnectionString;
        }

        public DatabaseController(string connectionString)
        {
            _connectionString = connectionString;
        }

        public List<Movie> GetMovies()
        {
            var movies = new List<Movie>();

            using (var conn = new SqlConnection(_connectionString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();

                foreach (var id in Movie.MyListOfMovies)
                {
                    cmd.CommandText = "SELECT * FROM MOVIES where MovieID = '" + id + "'";

                    Debug.WriteLine("Selecting: " + id);

                    using (var reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            var movie = ParseMovie(reader);
                            movie = PopulateMovie(movie);
                            movies.Add(movie);
                            Debug.WriteLine(movie.Title + " Written. ");
                        }
                    }
                }
            }

            return movies;
        }

        public Movie PopulateMovie(Movie movie)
        {
            var reviews = new List<Review>();
            var genres = new List<Genre>();

            using (var conn = new SqlConnection(_connectionString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "SELECT * FROM Reviews where MovieId = '" + movie.Id + "'";
                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        reviews.Add(ParseReview(reader));
                    }
                }


                cmd.CommandText = "SELECT * FROM Genres where MovieId = '" + movie.Id + "'";

                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        genres.Add(ParseGenre(reader));
                    }
                }
            }

            movie.Reviews = reviews;
            movie.Genres = genres;

            return movie;
        }


        public void InsertInsightToNoSql(Insight watsonResult)
        {
            const string uri = "mongodb://ACiobanu:Christtian2@ds060649.mlab.com:60649/imdb";
            var client = new MongoClient(uri);
            var mongoDb = client.GetDatabase("imdb");
            var collection = mongoDb.GetCollection<BsonDocument>("MovieInsights");
            var bsonDocument = watsonResult.ToBsonDocument();

            collection.InsertOne(bsonDocument);

        }

        public void InsertMovieToNoSql(Movie movie)
        {
            const string uri = "mongodb://ACiobanu:Christtian2@ds060649.mlab.com:60649/imdb";
            var client = new MongoClient(uri);
            var mongoDb = client.GetDatabase("imdb");
            var collection = mongoDb.GetCollection<BsonDocument>("Movies");
            var bsonDocument = movie.ToBsonDocument();

            collection.InsertOne(bsonDocument);
        }

        public void InsertInsightToLocalNoSql(Insight watsonResult)
        {
            const string uri = "mongodb://localhost/projectimdb";
            var client = new MongoClient(uri);
            var mongoDb = client.GetDatabase("projectimdb");
            var collection = mongoDb.GetCollection<BsonDocument>("MovieInsights");
            var bsonDocument = watsonResult.ToBsonDocument();

            collection.InsertOne(bsonDocument);

        }

        public void InserMovieToLocalNoSql(Movie movie)
        {
            const string uri = "mongodb://localhost/projectimdb";
            var client = new MongoClient(uri);
            var mongoDb = client.GetDatabase("projectimdb");
            var collection = mongoDb.GetCollection<BsonDocument>("Movies");
            var bsonDocument = movie.ToBsonDocument();

            collection.InsertOne(bsonDocument);
        }

        private Movie ParseMovie(SqlDataReader reader)
        {
            var movie = new Movie
            {
                Title = reader.GetString(reader.GetOrdinal("Title")),
                Id = reader.GetString(reader.GetOrdinal("MovieId")),
                Year = reader.GetInt32(reader.GetOrdinal("Year")),
                PlotSummary = reader.GetString(reader.GetOrdinal("PlotSummary")),
                PosterLink = reader.GetString(reader.GetOrdinal("PosterLink")),
                Score = (double) reader.GetDecimal(reader.GetOrdinal("Score"))
            };
            return movie;
        }

        private Review ParseReview(SqlDataReader reader)
        {
            var review = new Review
            {
                Id = reader.GetInt32(reader.GetOrdinal("Id")),
                MovieId = reader.GetString(reader.GetOrdinal("MovieId")),
                Score = (double) reader.GetDecimal(reader.GetOrdinal("Score")),
                Body = reader.GetString(reader.GetOrdinal("Body"))
            };
            return review;
        }

        private Genre ParseGenre(SqlDataReader reader)
        {
            var genre = new Genre
            {
                MovieId = reader.GetString(reader.GetOrdinal("MovieId")),
                GenreType = reader.GetString(reader.GetOrdinal("Genre"))
            };

            return genre;
        }
    }
}