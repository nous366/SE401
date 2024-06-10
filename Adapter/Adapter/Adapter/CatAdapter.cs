using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    class CatAdapter : IAnimal
    {
        private Cat _cat;

        public CatAdapter(Cat cat)
        {
            _cat = cat;
        }

        public void MakeSound()
        {
            _cat.Meow();
        }
    }
}
