using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Watson.Model;

namespace Watson.Controllers
{
    interface IDatabaseController
    {
        /*
         *  Selects all movies from the MSSQL database and returns them as a List of movie entities 
         */
        List<Movie> GetMovies();

        /*
         * Fills in the missing information for a single movie, use within a loop to populate entire movie list
         */
        Movie PopulateMovie(Movie movie);


        /*
         * Inserts a json result given by watson into the noSql database
         */

        void InsertInsightToNoSql(Insight watsonResult);
    }
}