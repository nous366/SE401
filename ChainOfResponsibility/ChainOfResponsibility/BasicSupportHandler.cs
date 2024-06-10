using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    class BasicSupportHandler : Handler
    {
        public override void HandleRequest(Request request)
        {
            if (request.Severity <= 1)
            {
                Console.WriteLine("BasicSupportHandler: Handling request - " + request.Description);
            }
            else if (NextHandler != null)
            {
                NextHandler.HandleRequest(request);
            }
        }
    }
}
