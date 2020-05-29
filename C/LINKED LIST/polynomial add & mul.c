#include<stdio.h>
#include<conio.h>
struct node
{
   float c;
   int e;
   struct node *link;
};
typedef struct node NODE;

NODE* create(NODE*start)
{
   NODE *p,*q;
   int i,n,ex;
   float co;
   printf("\nenter the no. of terms:");
   scanf("%d",&n);
   for(i=1;i<=n;i++)
   {
      printf("enter the cofficient of term %d:",i);
      scanf("%f",&co);
      printf("enter the exponent of term %d:",i);
      scanf("%d",&ex);
      p=(NODE*)malloc(sizeof(NODE));
      p->c=co;
      p->e=ex;
      if(start==NULL || ex>(start->e))
      {
        p->link=start;
        start=p;
      }
      else
      {
        q=start;
        while(q->link!=NULL && (q->e)>=ex)
        {
           q=q->link;
        }
        p->link=q->link;
        q->link=p;
      }
   }
   return(start);
}

NODE* insert(NODE *start,float co,int ex)
{
   NODE *p,*q;
   p=(NODE*)malloc(sizeof(NODE));
   p->c=co;
   p->e=ex;
   if(start==NULL)
   {
      p->link=start;
      start=p;
   }
   else
   {
      q=start;
      while(q->link!=NULL)
      {
        q=q->link;
      }
      p->link=q->link;
      q->link=p;
   }
   return(start);
}

void display(NODE *p)
{
   if(p==NULL)
   {
      printf("zero polynomial");
   }
   else
   {
       while(p!=NULL)
       {
         printf("%.1fx^%d",p->c,p->e);
         p=p->link;
         if(p!=NULL)
            printf(" + ");
         else
            printf("\n");
       }
   }
}

void polyadd(NODE *p1,NODE *p2)
{
   NODE *p;
   p=NULL;
   while(p1!=NULL && p2!=NULL)
   {
      if((p1->e)>(p2->e))
      {
         p=insert(p,p1->c,p1->e);
         p1=p1->link;
      }
      else if((p2->e)>(p1->e))
      {
         p=insert(p,p2->c,p2->e);
         p1=p1->link;
      }
      else if((p1->e)==(p2->e))
      {
         p=insert(p,p1->c+p2->c,p2->e);
         p1=p1->link;
         p2=p2->link;
      }
   }            
   while(p1!=NULL)
   {
      p=insert(p,p1->c,p1->e);
      p1=p1->link;
   }
   while(p2!=NULL)
   {
      p=insert(p,p2->c,p2->e);
      p2=p2->link;
   }
   printf("added polynomial is:");
   display(p);
}

/*void polymul(NODE*p1,NODE*p2)
{
   NODE *p;
   p=NULL;
   if(p1==NULL || p2==NULL)
   {
     printf("multiple polynomial is zero polynomial");
   }
   else
   {
       while(p1!=NULL)
       {
          while(p2!=NULL)
          {
             p=insert_s(p,(p1->c)*(p2->c),(p1->e)+(p2->e));
             p2=p2->link;
          }
          p1=p1->link;
       }
       printf("multiple polynomial is:");
       display(p);  
   }
}*/

void main()
{
     NODE *s1=NULL,*s2=NULL;
     printf("enter polynomial 1:");
     s1=create(s1);
     printf("enter polynomial 2:");
     s2=create(s2);
     printf("polynomail 1 is:");
     display(s1);
     printf("polynomail 2 is:");
     display(s2);
     polyadd(s1,s2);
   //  polymul(s1,s2);
}
