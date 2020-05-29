#include<stdio.h>
#include<conio.h>

int partition(int a[],int low,int up)
{
   int temp,i,j,pivot;
   i=low+1;
   j=up;
   pivot=a[low];
   while(i<=j)
   {
     while((a[i]<pivot) && (i<up))
      i++;
     while(a[j]>pivot)
      j--;
     if(i<j)
     {
       temp=a[i];
       a[i]=a[j];
       a[j]=temp;
       i++;
       j--;
     }
     else
       i++;
       
   }
   a[low]=a[j];
   a[j]=pivot;
   return j;
}

void quick(int a[],int low,int up)
{
   int pivloc;
   if(low>=up)
    return;
   pivloc=partition(a,low,up);
   quick(a,low,pivloc-1); //process left subtree
   quick(a,pivloc+1,up);  //process right subtree
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
  quick(a,0,n-1);
  printf("sorted list is:\n\t");
  for(i=0;i<n;i++)
  {
    printf("%d\n\t",a[i]);
  }
getch();
}
