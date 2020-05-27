#include<stdio.h>
#include<conio.h>

struct node 
{
  int n,pr;
  struct node *next;
}*start=NULL;
typedef struct node NODE;

//INSERTION OF DATA IN PRIORITY ORDER
void insert()
{
   NODE *p,*q,*r;
   int a,b;
   p=(NODE*)malloc(sizeof(NODE));
   printf("enter the element:");
   scanf("%d",&a);
   printf("enter the priority:");
   scanf("%d",&b);
   p->n=a;
   p->pr=b;
   if(start==NULL)
   {
     start=p;
     p->next=NULL;
   }
   else if(b<(start->pr))
   {
     p->next=start;
     start=p;
   }
   else
   {
     q=start;
     while(q->pr<=p->pr)
     {
       r=q;
       q=q->next;
       if(q==NULL)
         break;
     }
     p->next=r->next;
     r->next=p;
   }
}

//DELETION OF DATA ON THE BASE OF PRIORITY
void deletion()
{
   NODE *p,*q,*r;
   int no,count=0;
   p=start;
   r=start;
   if(start==NULL)
   {
      printf("Queue is empty");
   }
   else 
   {
     printf("enter the priority no.:");
     scanf("%d",&no);
     while(r!=NULL)
     {
       if(no==r->pr)
        {
         count++;
        }
       r=r->next;
         
     }
     if(count==0)
     {
       printf("there no element of entered priority");
     }
     else if(no==start->pr)
     {
       printf("no. deleted is %d",p->n);
       start=p->next;
     free(p);  
     }
     else
     {
       while(p->pr!=no)
       {
         q=p;
         p=p->next;
       }
       q->next=p->next;
       printf("no.deleted is %d",p->n);
     free(p);
     }
   }
}

//DISPLAYING THE DATA
void display()
{
    NODE *p;
    p=start;
    printf("DATA\tPRIORITY\n");
    while(p!=NULL)
    {
      printf(" %d\t  %d\n",p->n,p->pr);
      p=p->next;
    }
}

//MAIN FUNCTION
main()
{
     int ch;
     while(1)
     {
       printf("\n1:insertion\n2:deletion\n3:display\n4:exit\n");
       printf("enter your choice:");
       scanf("%d",&ch);
       switch(ch)
       {
          case 1:insert();
                 break;
          case 2:deletion();
                 break;
          case 3:display();
                 break;
          case 4:exit(1);
          default:printf("enter correct choice!!!");
       }
     }
}
