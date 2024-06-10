using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    class Request
    {
        public string Description { get; }
        public int Severity { get; }

        public Request(string description, int severity)
        {
            Description = description;
            Severity = severity;
        }
    }
}
