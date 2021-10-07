using System;

namespace _53___Highest_Prime_Factor
{

    class Prime{

        public int current = 1;
        public int max = 0;
        public Prime(int number){
            this.current = this.firstPrime(number);
            this.max = number;
        }

        public void setNextPrime(){
            if(this.current != this.max){    
                for(int i = this.current+1; i <= this.max; i++){
                    if(isPrime(i)){
                        this.current = i;
                        break;
                    }
                }
            }
        }
        private int firstPrime(int number){
            for(int i = 2; i <= number; i++){
                if(isPrime(i)){
                    return i;
                }
            }
            return number;
        }
        private bool isPrime(int number){
            int flag = 0;
            for(int i = 1; i <= number; i++){
                if(number % i == 0){
                    flag++;
                }
            }

            return flag == 2 ? true : false;

        }
    }
    class Program
    {

        static int HighestPrime(int number){
            Prime list = new Prime(number);
            int max = 1;
            while(number != 1){
                if(number % list.current == 0){
                    number = number/list.current;
                    max = list.current;
                }
                else{
                    list.setNextPrime();
                }
            }
            return max;
        }
        static void Main(string[] args)
        {
            int number =  int.Parse(Console.ReadLine());
            Console.WriteLine(HighestPrime(number));
        }
    }
}
