#include<stdio.h>
#include<conio.h>
struct stack
{
   int n;
   struct stack *p;
}*tos=NULL;

typedef struct stack S;
void push();
int pop();
void display();
void exit(int);
main()
{
     int choice,no;
     do
     {
     printf("\n1:push \n2:pop \n3:traverse \n4:exit\n");
     printf("enter your choice:");
     
     scanf("%d",&choice);
      
      switch(choice)
      {
        case 1:push();
          
        break;
        case 2:no=pop();
        printf("\nno.popped is %d",no);
          
        break;
        case 3:display();
          
        break;
        case 4:exit(1);
      }
    
     }while(choice!=4);
getch();
}

void push()
{
     S *p1;
     p1=(S*)malloc(sizeof(S));
         printf("enter the element:");
         scanf("%d",&p1->n);
         p1->p=tos;
         tos=p1;
}

int pop()
{
    int X;
    S *p1;
    p1=tos;
    if(tos==NULL)
    printf("stack is empty");
    else
    {
        tos=tos->p;
        X=p1->n;   
    return(X);
    }
}    
         
void display()
{
     S *p1;
     p1=tos;
     printf("elements are present in stack:\n");
     while(p1!=NULL)
     {
       printf("%d\n",p1->n);
       p1=p1->p;
     }
}
