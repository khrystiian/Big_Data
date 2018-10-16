using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Watson.Model;

namespace Watson
{
    public class Movie
    {
        public static string[] MyListOfMovies = new[]
        {
            "tt0086190",
            "tt0086250",
            "tt0086879",
            "tt0087544",
            "tt0087843",
            "tt0088247",
            "tt0088763",
            "tt0089881",
            "tt0090605",
            "tt0091251",
            "tt0091763",
            "tt0092005",
            "tt0093058",
            "tt0093779",
            "tt0095016",
            "tt0095327",
            "tt0095765",
            "tt0096283",
            "tt0097576",
            "tt0099685",
            "tt0101414",
            "tt0102926",
            "tt0103064",
            "tt0105236",
            "tt0105695",
            "tt0107048",
            "tt0107207",
            "tt0107290",
            "tt0108052",
            "tt0109117",
            "tt0109830",
            "tt0110357",
            "tt0110413",
            "tt0110912",
            "tt0111161",
            "tt0112471",
            "tt0112573",
            "tt0112641",
            "tt0113247",
            "tt0113277",
            "tt0114369",
            "tt0114709",
            "tt0114746",
            "tt0114814",
            "tt0116231",
            "tt0116282",
            "tt0117951",
            "tt0118715",
            "tt0118799",
            "tt0118849"
        };


        public static string[] MySmallerListOfMovies = new[]
        {
            "tt0086190",
            "tt0086250"

        };

        public string Id { get; set; }
        public string Title { get; set; }
        public int Year { get; set; }

        public string PlotSummary { get; set; }
        public string PosterLink { get; set; }
        public double Score { get; set; }

        public Boolean InProgress { get; set; }

        public Boolean Finished { get; set; }

        public List<Review> Reviews { get; set; }

        public List<Genre> Genres { get; set; }
    }
}