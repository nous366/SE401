using ChainOfResponsibility;
using System;

namespace ChainOfResponsibility
{
    class Program
    {
        static void Main(string[] args)
        {
            // Tạo các handler
            Handler basicSupport = new BasicSupportHandler();
            Handler advancedSupport = new AdvancedSupportHandler();
            Handler expertSupport = new ExpertSupportHandler();

            // Thiết lập chuỗi trách nhiệm
            basicSupport.SetNextHandler(advancedSupport);
            advancedSupport.SetNextHandler(expertSupport);

            // Tạo các yêu cầu
            Request lowSeverityRequest = new Request("Low severity issue", 1);
            Request mediumSeverityRequest = new Request("Medium severity issue", 2);
            Request highSeverityRequest = new Request("High severity issue", 3);
            Request tooHighSeverityRequest = new Request("Too high severity issue", 4);

            // Xử lý các yêu cầu
            basicSupport.HandleRequest(lowSeverityRequest);
            basicSupport.HandleRequest(mediumSeverityRequest);
            basicSupport.HandleRequest(highSeverityRequest);
            basicSupport.HandleRequest(tooHighSeverityRequest);
        }
    }
}