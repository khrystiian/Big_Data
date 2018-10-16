using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Watson.Model
{
    public class Insight
    {
        public int WordCount { get; set; }
        public string ProcessedLanguage { get; set; }
        public List<Personality> Personality { get; set; }
        public List<Need> Needs { get; set; }
        public List<Value> Values { get; set; }
        public List<object> Warnings { get; set; }
    }
}