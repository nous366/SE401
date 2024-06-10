using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    class AdvancedSupportHandler : Handler
    {
        public override void HandleRequest(Request request)
        {
            if (request.Severity <= 2)
            {
                Console.WriteLine("AdvancedSupportHandler: Handling request - " + request.Description);
            }
            else if (NextHandler != null)
            {
                NextHandler.HandleRequest(request);
            }
        }
    }
}
