#include<stdio.h>
#include<conio.h>
#define MAX 15

int queue[5],info,i;
int front=-1,rear=-1;

void insert()
{
   if(front==(rear+1)%MAX)
   {
      printf("queue is full\n");
   }
   else
   {
      printf("enter the element:");
      scanf("%d",&info);
      if(front==-1)
      {
        front=0;
       // rear=0;
      }
      rear=(rear+1)%MAX;
      queue[rear]=info;
   }
}

void del()
{
  if(front!=-1)
  {
     info=queue[front];
     if(front==rear)
     {
        front=rear=-1;
     }
     else
     {
        front=(front+1)%MAX;
     }
     printf("no. deleted is %d",info);
  }
  else
  {
     printf("queue is empty");
  }
}

void display()
{
  if(front==-1)
  {
    printf("queue is empty");
  }
  else
  {
     printf("queue:\n");
     for(i=front;i!=rear;i=(i+1)%MAX)
     { 
       printf("%d\n",queue[i]);
     }
     printf("%d\n",queue[i]);
  }
}

main()
{
   int choice;
   while(1)
   {
      printf("\n1:insertion\n2:deletion\n3:display\n4:exit\n");
      printf("enter your choice:");
      scanf("%d",&choice);
      switch(choice)
      {
         case 1:
               insert();
               break;
         case 2:
               del();
               break;
         case 3:
               display();
               break;
         case 4:
               exit(1);
         default:
               printf("you have entered wrong choice");
      }              
   };

}






