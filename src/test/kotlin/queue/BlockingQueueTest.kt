package queue

import org.junit.Test

class BlockingQueueTest {
    @Test
    fun testQueue() {
        val queue = BlockingQueue<Int>(4)
        Thread {
            for (i in 0..10) {
                println("- ${queue.take()}")
                Thread.sleep(2000)
            }
        }.start()
        Thread.sleep(3000)
        for (i in 0..10) {
            Thread.sleep(1000)
            println("+ ${queue.put(10)}")
            println(queue)
        }
    }
}