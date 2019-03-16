import org.junit.Test

class BiTreeTest {
    @Test
    fun dfsRecursive() {
        val searchTree = SearchTree()
        searchTree.dfsRecursive()

        searchTree.insert(32)
        searchTree.dfsRecursive()

        searchTree.insert(16)
        searchTree.dfsRecursive()

        searchTree.insert(8)
        searchTree.dfsRecursive()

        searchTree.insert(64)
        searchTree.dfsRecursive()

        searchTree.insert(24)
        searchTree.dfsRecursive()
    }

    @Test
    fun dfsStack() {
        val searchTree = SearchTree()
        searchTree.dfsStack()

        searchTree.insert(32)
        searchTree.dfsStack()

        searchTree.insert(16)
        searchTree.dfsStack()

        searchTree.insert(8)
        searchTree.dfsStack()

        searchTree.insert(64)
        searchTree.dfsStack()

        searchTree.insert(24)
        searchTree.dfsStack()
    }

    @Test
    fun bfsStack() {
        val searchTree = SearchTree()
        searchTree.bfsQueue()

        searchTree.insert(32)
        searchTree.bfsQueue()

        searchTree.insert(16)
        searchTree.bfsQueue()

        searchTree.insert(8)
        searchTree.bfsQueue()

        searchTree.insert(64)
        searchTree.bfsQueue()

        searchTree.insert(24)
        searchTree.bfsQueue()
    }

    @Test
    fun leaves() {
        val searchTree = SearchTree()
        searchTree.leaves()

        searchTree.insert(32)
        searchTree.leaves()

        searchTree.insert(16)
        searchTree.leaves()

        searchTree.insert(8)
        searchTree.leaves()

        searchTree.insert(64)
        searchTree.leaves()

        searchTree.insert(24)
        searchTree.leaves()
    }

    @Test
    fun levelSizes() {
        val searchTree = SearchTree()
        searchTree.insert(32)
        searchTree.insert(16)
        searchTree.insert(8)
        searchTree.insert(64)
        searchTree.insert(24)
        searchTree.insert(128)
        searchTree.dfsRecursive()
        searchTree.levelSizes()
    }

    @Test
    fun listLevel() {
        val searchTree = SearchTree()
        searchTree.insert(32)
        searchTree.insert(16)
        searchTree.insert(8)
        searchTree.insert(64)
        searchTree.insert(24)
        searchTree.insert(128)
        searchTree.insert(4)
        searchTree.dfsRecursive()
        searchTree.listLevel(0)
        searchTree.listLevel(1)
        searchTree.listLevel(2)
        searchTree.listLevel(3)
        searchTree.listLevel(4)
    }

    @Test
    fun min() {
        val searchTree = SearchTree()
        searchTree.insert(32)
        searchTree.insert(16)
        searchTree.insert(8)
        searchTree.insert(64)
        searchTree.insert(24)
        searchTree.insert(128)
        searchTree.insert(4)
        searchTree.dfsRecursive()
        println(searchTree.min())
    }

    @Test
    fun max() {
        val searchTree = SearchTree()
        searchTree.insert(32)
        searchTree.insert(16)
        searchTree.insert(8)
        searchTree.insert(64)
        searchTree.insert(24)
        searchTree.insert(128)
        searchTree.insert(4)
        searchTree.dfsRecursive()
        println(searchTree.max())
    }

    @Test
    fun search() {
        val searchTree = SearchTree()
        searchTree.insert(32)
        searchTree.insert(16)
        searchTree.insert(8)
        searchTree.insert(64)
        searchTree.insert(24)
        searchTree.insert(128)
        searchTree.insert(4)
        searchTree.dfsRecursive()
        println(searchTree.search(32))
        println(searchTree.search(16))
        println(searchTree.search(8))
        println(searchTree.search(64))
        println(searchTree.search(24))
        println(searchTree.search(128))
        println(searchTree.search(4))
        println(searchTree.search(0))
    }
}