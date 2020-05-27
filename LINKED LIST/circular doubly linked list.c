#include<stdio.h>
#include<conio.h>
struct node
{
   int n;
   struct node *next;
   struct node *prev;
}*start=NULL,*last=NULL;
typedef struct node NODE;
 
//insertion from front
void infront()
{
   NODE *p;
   p=(NODE*)malloc(sizeof(NODE));
   printf("enter the number:");
   scanf("%d",&p->n);
   if(start==NULL)
   {
     p->next=p;
     p->prev=p;
     start=last=p;
   }
   else
   {
     p->next=start;
     start->prev=p;
     start=p;
     last->next=p;
     p->prev=last;
   }
}

// insertion from end
void inend()
{
   NODE *p;
   p=(NODE*)malloc(sizeof(NODE));
   printf("enter the number:");
   scanf("%d",&p->n);
   if(start==NULL)
   {
      p->next=p;
      p->prev=p;
      start=last=p;
   }
   else
   {
      last->next=p;
      p->prev=last;
      last=p;
      p->next=start;
      start->prev=p;
   }
}

//deletion from front
void delfront()
{
   NODE *p;
   p=start;
   if(p==NULL)
   {
      printf("list is empty...\n");
   }
   else if(start==last)
   {
      printf("no. deleted is %d\n",p->n);
      free(p);
      start=last=NULL;
   }
   else
   {
      start=start->next;
      start->prev=last;
      last->next=start;
      printf("no. deleted is %d\n",p->n);
      free(p);
   }
}

//deletion from end
void delend()
{
   NODE *p;
   p=last;
   if(p==NULL)
   {
      printf("list is empty...\n");
   }
   else if(start==last)
   {
      printf("no. deleted is %d\n",p->n);
      free(p);
      start=last=NULL;
   }
   else
   {
      last=last->prev;
      last->next=start;
      start->prev=last;
      printf("no. deleted is %d\n",p->n);
      free(p);
   }
}

//traversing of list
void trav(NODE *p)
{
   if(p==NULL)
   {
     printf("list is empty...\n");
   }
   else
   {
     printf("list is:\n");
     while(p->next!=start)
     {
       printf("%d\n",p->n);
       p=p->next;
     }
     printf("%d\n",p->n);
   }
}

//main function 
main()
{
   int c;
   while(1)
   {
     printf("\n1:insert from front\n2:insert from end\n3:delete from front\n4:delete from end\n5:traverse list\n6:exit\n");
     printf("enter your choice:");
     scanf("%d",&c);
     switch(c)
     {
        case 1:infront();
               break;
        case 2:inend();
               break;
        case 3:delfront();
               break;
        case 4:delend();
               break;
        case 5:trav(start);
               break;
        case 6:exit(1);
        default:printf("plz!!! enter correct choice...");
     }
   }
getch();
}
