using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Watson.Controllers;

namespace Watson
{
    class Program
    {
        static void Main(string[] args)
        {
            ProcessingController processingController = new ProcessingController();
            processingController.ProcessMovies();

        }
    }
}