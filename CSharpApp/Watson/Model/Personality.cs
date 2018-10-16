using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Watson.Model
{
    public class Personality
    {
        public string TraitId { get; set; }
        public string Name { get; set; }
        public string Category { get; set; }
        public double Percentile { get; set; }
        public List<PersonalityChild> Children { get; set; }

        public class PersonalityChild
        {
            public string TraitId { get; set; }
            public string Name { get; set; }
            public string Category { get; set; }
            public double Percentile { get; set; }
        }
    }
}