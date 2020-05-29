#include<stdio.h>
#include<conio.h>
void insert();
void del();
void display();
int queue[5],info,i;
int front=-1,rear=-1;
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
               getch();
               break;
         case 2:
               del();
               getch();
               break;
         case 3:
               display();
               getch();
               break;
         case 4:
               exit(1);
         default:
               printf("you have entered wrong choice");
      }              
   };

}

void insert()
{
   if(rear<4)
   {
      printf("enter the element:");
      scanf("%d",&info);
      if(rear==-1)
      {
        front=0;
      }
      rear=rear+1;
      queue[rear]=info;
   }
   else
   {
      printf("queue is full");
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
        front=front+1;
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
     for(i=front;i<=rear;i++)
       printf("%d\n",queue[i]);
  }
}
