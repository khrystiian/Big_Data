using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using RestSharp.Serializers;

namespace Watson.Controllers
{
    class ProcessingController : IProcessingController
    {
        public bool ProcessMovies()
        {
            var dbController = new DatabaseController();
            var watsonController = new WatsonController();

            //get the movies from the SQL database
            var movies = dbController.GetMovies();

            //for every movie run the Query Watson method  
            foreach (var movie in movies)
            {


                var movieInsight = watsonController.QueryWatson(movie);
                // insert the insights and the movies in thw NoSQL database


                dbController.InsertInsightToNoSql(movieInsight);
                // dbController.InsertInsightToLocalNoSql(movieInsight);
                dbController.InsertMovieToNoSql(movie);
                //  dbController.InserMovieToLocalNoSql(movie);

                //write the inserted movie's title to the console
                Console.WriteLine(movie.Title + " inserted!");

            }

            Console.WriteLine("Done!");
            Console.ReadLine();

            return true;
        }
    }
}