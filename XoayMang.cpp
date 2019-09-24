#include <iostream>
using namespace std;
void nhapMang(int a[],int n){
	for(int i=0;i<n;i++){
		cout<<"\ta["<<i<<"]= ";
		cin>>a[i];
	}
}
void xuatMang(int a[],int n){
	for(int i=0;i<n;i++){
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
void dichTrai(int a[],int n){
	int temp= a[0];
	for(int i=0;i<n-1;i++){
		a[i] = a[i+1];
	}
	a[n-1] = temp;
}
void dichPhai(int a[],int n){
	int temp= a[n-1];
	for(int i=n-1;i>=0;i--){
		a[i] = a[i-1];
	}
	a[0] = temp;
}
void xoayTrai(int a[],int n,int vt){
	for(int i=1;i<=vt;i++)
		dichTrai(a,n);
}
void xoayPhai(int a[],int n,int vt){
	for(int i=1;i<=vt;i++)
		dichPhai(a,n);
}
int main(){
	int n;
	cout<<"nhap so phan tu: ";cin>>n;
	int a[n];
	nhapMang(a,n);
	char t;
	int k;
	cout<<"nhap so vong dich: ";cin>>k;
	do{
		cout<<"nhap chieu dich t/p: ";cin>>t;
		if (t!='t' && t!='p') cout<<"Nhap lai t/p ?\n";
	}while(t!='t' && t!='p');
	
	int vt = k%n;
	if (t =='t'){
		xoayTrai(a,n,vt);
	}
	else xoayPhai(a,n,vt);
	cout<<"Mang sau khi dich: ";
	xuatMang(a,n);
	return 0;
}
