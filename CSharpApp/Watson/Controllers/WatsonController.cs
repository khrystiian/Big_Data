using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using RestSharp;
using Watson.Model;

namespace Watson.Controllers
{
    class WatsonController : IWatsonController
    {
        public RestClient client =
            new RestClient("https://gateway.watsonplatform.net/personality-insights/api");

            // shitty temp account -- PLEASE USE YOUR OWN CREDENTIALS IF YOU WANT TO RUN THIS CODE
        private const string Username = "29d66d97-967c-4bc2-807d-25eb91f300f9";
        private const string Password = "4UceyXjRgc6C";

        private Insight PostInsight(string watsonFeed)
        {
            string resource = "/v3/profile";
            string versionQuery = "version";
            var versionValue = "2017-04-15";

            RestRequest request = new RestRequest(resource)
            {
                Method = Method.POST,
                JsonSerializer = new RestSharp.Serializers.JsonSerializer(),
                Credentials = new NetworkCredential(Username, Password),
            };
            request.AddQueryParameter(versionQuery, versionValue);
            request.AddHeader("Content-Type", "text/plain");


            request.AddParameter("text/plain", watsonFeed, ParameterType.RequestBody);


            var dataResponse = client.Execute<Insight>(request);

            return dataResponse.Data;
        }

        public Insight QueryWatson(Movie movie)
        {

            var sb = new StringBuilder();
            var watsonFeed = "";

            foreach (var movieReview in movie.Reviews)
            {
                var body = movieReview.Body;

                sb.Append(body);
            }

            watsonFeed = sb.ToString();

            var movieInsight = PostInsight(watsonFeed);

            return movieInsight;
        }
    }
}