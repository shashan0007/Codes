#include<stdio.h>
#include<conio.h>
void push();
int pop();
void traverse();
void merge();
void Exit(int);
int stack[5];
int top = -1;
int main()
{
     int choice,no;
     do
     {
            
         printf("\n1:push \n2:pop \n3:traverse \n4:merge \n5:exit\n");
         printf("enter your choice:");
         scanf("%d",&choice);
          switch(choice)
              {
                case 1: push();
                break;
                case 2:no = pop();
                printf("\nno.popped is %d",no);
                break;
                case 3:traverse();
                break;
                case 4:merge();
                break;
                case 5:exit(0);
              }
             }while(choice!=4);
        }

void push()
{
     int item;
     if(top == 4)
     printf("stack is full");
     else
     {
         printf("enter the element:");
         scanf("%d",&item);
         top++;
         stack[top]=item;
     }
}

int pop()
{
    int item;
    if(top==-1)
    printf("stack is empty");
    else
    {
        item=stack[top];
        top=top-1;   
    return(item);
    }
}    
         
void traverse()
{
     int i;
     if(top==-1)
     printf("stack is empty");
     else
     {
         for(i=top;i>=0;i--)
         {
           printf("%d\n",stack[i]);
         }
     }
}

void merge()
{
     int arr3[10],arr1[5],arr2[5],i,ji;
    
     printf("enter the first array\n");
    
     for(i=0;i<5;i++)
        scanf("%d",&arr1[i]);
    
    printf("\nenter the second element\n");
    
    for(i=0;i<5;i++)
      scanf("%d",&arr2[i]);
      printf("hiiii");
       
       ji = 0;
       while (ji<5)    {
                printf("hi");ji++;}
            
     for(i=5,ji=0;ji<5;i++,ji++)
          arr3[i]=arr2[ji];
     
     printf("merged array is:\n");
     for(i=0;i<10;i++)
     {
       printf("%d",arr3[i]);
     }
}         
                
     
