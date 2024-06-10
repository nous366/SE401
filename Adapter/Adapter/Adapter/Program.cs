using Adapter;
using System;

namespace Adapter
{
    class Program
    {
        static void Main(string[] args)
        {
            // Tạo đối tượng của Dog và Cat
            Dog dog = new Dog();
            Cat cat = new Cat();

            // Tạo đối tượng Adapter cho Dog và Cat
            IAnimal dogAdapter = new DogAdapter(dog);
            IAnimal catAdapter = new CatAdapter(cat);

            // Gọi phương thức MakeSound thông qua các Adapter
            dogAdapter.MakeSound(); // Output: Woof!
            catAdapter.MakeSound(); // Output: Meow!
        }
    }
}