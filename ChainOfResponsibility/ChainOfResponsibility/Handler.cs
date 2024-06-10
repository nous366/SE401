using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    abstract class Handler
    {
        protected Handler NextHandler;

        public void SetNextHandler(Handler nextHandler)
        {
            NextHandler = nextHandler;
        }

        public abstract void HandleRequest(Request request);
    }
}
