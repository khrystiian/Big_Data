using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Watson.Controllers
{
    interface IProcessingController
    {
        /*
         * Helper method to start the process of moving the movies to watson
         */
        bool ProcessMovies();
    }
}
