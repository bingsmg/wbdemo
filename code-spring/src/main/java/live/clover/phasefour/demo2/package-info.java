/**
 * <h1>该包主要实现 Spring 源码中 cache 功能相关的分析和使用</h1>
 *<p>
 *   Cacheable 注解用于标记一个方法可以从缓存中获取数据。<br>
 *  当调用被标记为 @Cacheable 的方法时，Spring会首先检查缓存中是否已经存在结果。
 *  如果存在，则直接返回缓存中的结果，而不执行方法体。<br>
 *  如果缓存中不存在结果，方法会执行，并将结果存入缓存，以供下次调用时使用。<br>
 *  通常在读取数据的方法上使用 @Cacheable，以避免重复执行相同的查询或计算操作。
 *</p>
 *<p>
 *   CachePut 注解用于更新或存储数据到缓存中。与 @Cacheable 不同，@CachePut 不会检查缓存中是否已经存在结果，而是强制执行方法体，并将结果存入缓存。
 *   它适用于希望更新缓存中的数据的情况。<br>
 *   通常在更新数据的方法上使用 @CachePut，以确保每次更新都会更新缓存中的数据。
 *</p>

 */
package live.clover.phasefour.demo2;