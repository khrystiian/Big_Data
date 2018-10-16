using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Watson.Controllers;

namespace DbTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestDatabaseGet()
        {
            var conString =
                "Data Source=tcp:eugenb.database.windows.net,1433; Initial Catalog=IMDB; User id=eugen ; Password=imdb2017!";

            DatabaseController db = new DatabaseController(conString);
            var result = db.GetMovies();

            Assert.IsTrue(result.Count > 0);
        }
    }
}