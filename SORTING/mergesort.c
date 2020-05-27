#include<stdio.h>
#include<conio.h>

void merge(int a[],int tp[],int L1,int U1,int L2,int U2)
{
   int i=L1;
   int j=L2;
   int k=L1;
   while((i<=U1) && (j<=U2))
   {
      if(a[i]<=a[j])
         tp[k++]=a[i++];
      else
         tp[k++]=a[j++];
   }
   while(i<=U1)
     tp[k++]=a[i++];
   while(j<=U2)
     tp[k++]=a[j++];
}

void copy(int a[],int tp[],int low,int up)
{
     int i;
     for(i=low;i<=up;i++)
     {
       a[i]=tp[i];
     }
}

void mergesort(int a[],int low,int up)
{
   int mid;
   int temp[up+1];
   if(low<up)
   {
      mid=(low+up)/2;
      mergesort(a,low,mid);  //sort a[low,mid]
      mergesort(a,mid+1,up); //sort a[mid+1:up]
      /* merge a[low:mid] and a[mid+1:up] to temp[low:up]*/
      merge(a,temp,low,mid,mid+1,up);
      copy(a,temp,low,up);  //copy temp[] to a[]
   }
}

void main()
{
  int a[100],n,i;
  printf("no. of elements in array:");
  scanf("%d",&n);
  printf("enter the elements:\n");
  for(i=0;i<n;i++)
  {
    scanf("%d",&a[i]);
  }
  mergesort(a,0,n-1);
  printf("sorted list is:\n\t");
  for(i=0;i<n;i++)
  {
    printf("%d\n\t",a[i]);
  }
getch();
}
