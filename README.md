[English](https://github.com/Gan-Jason/TCPConnectionCheck/blob/master/README_EN.md)
## 基于TCP协议的主机端口连接测试  
* 因前不久是网络安全周，我搭建在GCP上的SSR服务出现问题，经查后发现是端口被封，即经过该IP端口的流量全部被墙  
 
* 当时找原因也找了好一会，最后测试该IP的Socket连接才发现问题，因此写了一个测试端口的程序  
 
* 因为用Java写的，并没有GUI，也没有打包JAR，所以需要跑源码  
  

## 需要环境  
* JDK1.6以上即可
## 配置  
* 修改Configure.properties文件的IP和PORT即可  

