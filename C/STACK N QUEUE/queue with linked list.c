#include<stdio.h>
#include<conio.h>
struct node
{
   int n;
   struct node *next;
}*front=NULL,*rear=NULL;
typedef struct node NODE;

void insert()
{
   NODE *p;
   p=(NODE*)malloc(sizeof(NODE));
   printf("enter the element:");
   scanf("%d",&p->n);
   p->next=NULL;
   if(front==NULL)
   {
     front=p;
     rear=p;
   }
   else
   {
     rear->next=p;
     rear=p;
   }
}

void del()
{
  NODE *p;
  if(front==NULL)
  {
    printf("queue is empty..\n");
  }
  else
  {
    p=front;
    if(front==rear)
    {
      front=rear=NULL;
    }
    else
    {
      front=front->next;
    }  
    printf("deleted no. is %d\n",p->n);
    free(p);
  } 
}

void display()
{
  NODE *p;   
  if(front==NULL)
  {
    printf("queue is empty..\n");
  }
  else
  {
     p=front;
     printf("queue:\n");
     while(p!=NULL)
     {
       printf(" %d\n",p->n);
       p=p->next;
     }
  }
}

void main()
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
             //  getch();
               break;
         case 2:
               del();
             //  getch();
               break;
         case 3:
               display();
             //  getch();
               break;
         case 4:
               exit(1);
         default:
               printf("plz!!enter correct choice");
      }              
   }
}
