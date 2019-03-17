package queue

import java.util.*

class BlockingQueue<E>(val capacity: Int) {
    private val queue: ArrayDeque<E> = ArrayDeque(capacity)
    private val lock = Object()
    private var size = 0

    fun put(e: E): E {
        synchronized(lock) {
            while (size == capacity) {
                lock.wait()
            }
            if (size == 0) {
                lock.notifyAll()
            }
            size++
            queue.add(e)
            return e
        }
    }

    fun take(): E {
        synchronized(lock) {
            while (size == 0) {
                lock.wait()
            }
            if (size == capacity) {
                lock.notifyAll()
            }
            size--
            return queue.pop()
        }
    }

    override fun toString() = queue.toString()
}