using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using Watson.Model;

namespace Watson.Controllers
{
    interface IWatsonController
    {
        Insight QueryWatson(Movie movie);
    }
}