 #include<stdio.h>
char c[12] = "How are you";

void reverse(char *c)
{
  if(*c=='\0') return;
 else{
   reverse(c+1);

   printf("%c",*c);
 }
}
int main()
{
int i;
reverse(c);

return 0;

}
