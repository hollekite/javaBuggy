package com.book.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.InputStream;

/**
 *
 <cache
 name="categoryCache"                   #缓存的名字
 maxElementsInMemory="10000"            #允许在内存中缓存的元素个数  0 表示无限大
 eternal="false"                        #设置缓存对象是否为永久 true 为永久
 timeToIdleSeconds="120"                #对象在访问后 闲置的允许时间, 仅当eternal=false的时候生效,为0 表示可以无限闲置
 timeToLiveSeconds="120"                #对象的生命周期
 overflowToDisk="false"                 #内存不足时,是否启用磁盘缓存
 maxElementsOnDisk="10000000"           #磁盘最大缓存个数
 diskPersistent="false"                 #是否在磁盘重启时存储硬盘缓存数据
 diskExpiryThreadIntervalSeconds="120"  #磁盘失效线程运行时间间隔
 memoryStoreEvictionPolicy="LRU"        #缓存策略
 />



 name : 缓存的名称，可以通过指定名称获取指定的某个Cache对象

 maxElementsInMemory ：内存中允许存储的最大的元素个数，0代表无限个

 clearOnFlush：内存数量最大时是否清除。

 eternal ：设置缓存中对象是否为永久的，如果是，超时设置将被忽略，对象从不过期。根据存储数据的不同，例如一些静态不变的数据如省市区等可以设置为永不过时

 timeToIdleSeconds ： 设置对象在失效前的允许闲置时间（单位：秒）。仅当eternal=false对象不是永久有效时使用，可选属性，默认值是0，也就是可闲置时间无穷大。

 timeToLiveSeconds ：缓存数据的生存时间（TTL），也就是一个元素从构建到消亡的最大时间间隔值，这只能在元素不是永久驻留时有效，如果该值是0就意味着元素可以停顿无穷长的时间。

 overflowToDisk ：内存不足时，是否启用磁盘缓存。

 maxEntriesLocalDisk：当内存中对象数量达到maxElementsInMemory时，Ehcache将会对象写到磁盘中。

 maxElementsOnDisk：硬盘最大缓存个数。

 diskSpoolBufferSizeMB：这个参数设置DiskStore（磁盘缓存）的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区。

 diskPersistent：是否在VM重启时存储硬盘的缓存数据。默认值是false。

 diskExpiryThreadIntervalSeconds：磁盘失效线程运行时间间隔，默认是120秒。
 */

public class CacheUtil {
    private static CacheManager cacheManager = null;
    private Cache cache = null;

    static {
        //获得配置文件流
        InputStream inputStream = CacheUtil.class.getClassLoader().getResourceAsStream("ehcache.xml");
        //创建缓存管理器
        cacheManager = CacheManager.create(inputStream);
    }


    /**
     * 构造并 初始化cache
     * @param cacheName
     */
    public CacheUtil(String cacheName) {
        this.cache = CacheUtil.cacheManager.getCache(cacheName);
    }


    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public void addCache(String key,Object value){
        Element element = new Element(key,value);
        cache.put(element);
    }

    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    public Object getCache(String key){
        Element element = cache.get(key);
        if(element == null)
            return null;
        return element.getObjectValue();
    }

    /**
     * 删除cache
     * @param key
     */
    public void removeCache(String key){
        cache.remove(key);
    }

    /**
     * 刷新缓存
     */
    public void flushCache(){
        cache.flush();
    }


    /**
     * 关闭缓存管理器
     */
    public void closeManager(){
        CacheUtil.cacheManager.shutdown();
    }



}
