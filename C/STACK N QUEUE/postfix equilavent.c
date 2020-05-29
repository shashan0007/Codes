#include<stdio.h>
#include<conio.h>

int top=-1;
double res,op1,op2,s[20];
char sym,postfix[20];

double op(char s,double op1,double op2)
{
   switch(s)
   {
     case '+':
          return op1+op2;
     case '-':
          return op1-op2;
     case '*':
          return op1*op2;
     case '/':
          return op1/op2;
     case '^':
          return pow(op1,op2);
   }
}

void push(double item)
{
   top=top+1;
   s[top]=item;
}

double pop()
{
   double item;
   item=s[top];
   top=top-1;
   return item;
}

int isdigit(char s)
{
   return (s>='0' && s<='9');
}


main()
{
   int i;   
   printf("enter the postfix expression:");
   scanf("%s",postfix);
   for(i=0;i<strlen(postfix);i++)
   {
     sym=postfix[i];
     if(isdigit(sym))
     {
        push(sym-'0');
     }
     else
     {
        op2=pop();
        op1=pop();
        res=op(sym,op1,op2);
        push(res);
     }
   }
   res=pop();
   printf("the result is %f",res);
getch();
}       
