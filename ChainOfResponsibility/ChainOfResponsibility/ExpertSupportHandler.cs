using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    class ExpertSupportHandler : Handler
    {
        public override void HandleRequest(Request request)
        {
            if (request.Severity <= 3)
            {
                Console.WriteLine("ExpertSupportHandler: Handling request - " + request.Description);
            }
            else
            {
                Console.WriteLine("ExpertSupportHandler: Request too severe to handle - " + request.Description);
            }
        }
    }
}
