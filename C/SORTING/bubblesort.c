#include<stdio.h>
#include<conio.h>

void bubsort(int a[],int n)
{
  int temp,i,j;
  for(i=0;i<n;i++)
  {
    for(j=0;j<n-1-i;j++)
    {
      if(a[j]>a[j+1])
      {
        temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
      }
    }
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
  bubsort(a,n);
  printf("sorted list is:\n\t");
  for(i=0;i<n;i++)
  {
    printf("%d\n\t",a[i]);
  }
getch();
}
  
