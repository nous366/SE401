using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    class DogAdapter : IAnimal
    {
        private Dog _dog;

        public DogAdapter(Dog dog)
        {
            _dog = dog;
        }

        public void MakeSound()
        {
            _dog.Bark();
        }
    }
}
