package tree

import java.util.*

class Node(var value: Int, var left: Node? = null, var right: Node? = null, var parent: Node?) {
    override fun toString() = value.toString()
}

interface BiTree {
    fun root(): Node?
    fun insert(value: Int)
    fun remove(value: Int): Boolean
    fun search(value: Int): Node?
    fun dfsRecursive()
    fun dfsStack()
    fun bfsQueue()
    fun levelSizes()
    fun listLevel(level: Int)
    fun leaves()
    fun min(): Int?
    fun max(): Int?
}

class SearchTree : BiTree {
    var root: Node? = null

    override fun insert(value: Int) {
        if (root == null) {
            root = Node(value = value, parent = null)
        } else {
            insert(value, root!!)
        }
    }

    private fun insert(value: Int, into: Node) {
        if (value < into.value) {
            if (into.left == null) {
                into.left = Node(value = value, parent = into)
            } else insert(value, into.left!!)
        } else {
            if (into.right == null) {
                into.right = Node(value = value, parent = into)
            } else insert(value, into.right!!)
        }
    }

    override fun root() = root

    override fun search(value: Int): Node? {
        return search(root, value)
    }

    private fun search(subtree: Node?, value: Int): Node? {
        if (subtree == null) {
            return null
        }
        return when {
            subtree.value == value -> return subtree
            value < subtree.value -> search(subtree.left, value)
            else -> search(subtree.right, value)
        }
    }

    override fun remove(value: Int): Boolean {
        val toRemove = search(value)
        return if (toRemove == null) {
            false
        } else {
            remove(toRemove)
            true
        }
    }

    private fun remove(subTree: Node, value: Int): Boolean {
        val toRemove = search(subTree, value)
        return if (toRemove == null) {
            false
        } else {
            remove(toRemove)
            true
        }
    }

    private fun remove(node: Node) {
        if (node.left == null && node.right == null) {
            val parent = node.parent
            if (parent == null) {
                root = null
            } else {
                if (parent.right != null && parent.right!! == node) {
                    parent.right = null
                } else if (parent.left != null && parent.left!! == node) {
                    parent.left = null
                }
            }
            return
        }
        if (node.left == null && node.right != null) {
            val parent = node.parent
            if (parent == null) {
                root = node.right
                return
            }
            if (parent.right != null && parent.right!! == node) {
                parent.right = node.right
                node.right!!.parent = parent
            } else if (parent.left != null && parent.left!! == node) {
                parent.left = node.right
                node.right!!.parent = parent
            }
            return
        }
        if (node.right == null && node.left != null) {
            val parent = node.parent
            if (parent == null) {
                root = node.left
                return
            }
            if (parent.right != null && parent.right!! == node) {
                parent.right = node.left
                node.left!!.parent = parent
            } else if (parent.left != null && parent.left!! == node) {
                parent.left = node.left
                node.left!!.parent = parent
            }
            return
        }
        if (node.right != null && node.left != null) {
            val min = min(node.right!!)
            node.value = min.value
            remove(node.right!!, node.value)
        }
    }

    override fun min(): Int? {
        return if (root == null) {
            null
        } else {
            min(root!!).value
        }
    }

    private fun min(subtree: Node): Node {
        return if (subtree.left == null) {
            subtree
        } else min(subtree.left!!)
    }

    override fun max(): Int? {
        return if (root == null) {
            null
        } else {
            max(root!!).value
        }
    }

    private fun max(subtree: Node): Node {
        return if (subtree.right == null) {
            subtree
        } else max(subtree.right!!)
    }

    override fun dfsRecursive() {
        print("[")
        if (root != null) {
            dfsRecursive(root!!)
        }
        println("]")
    }

    private fun dfsRecursive(current: Node) {
        if (current.left != null) {
            dfsRecursive(current.left!!)
        }
        print(current.toString() + " ")
        if (current.right != null) {
            dfsRecursive(current.right!!)
        }
    }

    override fun dfsStack() {
        print("[")
        if (root != null) {
            val toVisit = Stack<Node>()
            toVisit.push(root)
            while (!toVisit.isEmpty()) {
                val current = toVisit.pop()
                print(current.toString() + " ")
                if (current.right != null) {
                    toVisit.add(current.right)
                }
                if (current.left != null) {
                    toVisit.add(current.left)
                }
            }
        }
        println("]")
    }

    override fun leaves() {
        print("[")
        if (root != null) {
            val visited = Stack<Node>()
            visited.push(root)
            while (!visited.isEmpty()) {
                val current = visited.pop()
                if (current.right != null) {
                    visited.add(current.right)
                }
                if (current.left != null) {
                    visited.add(current.left)
                }
                if (current.right == null && current.left == null) {
                    print(current.toString() + " ")
                }
            }
        }
        println("]")
    }


    override fun bfsQueue() {//? sorting order
        print("[")
        if (root != null) {
            val visited = LinkedList<Node>()
            visited.push(root)
            while (!visited.isEmpty()) {
                val current = visited.removeFirst()
                print(current.toString() + " ")
                if (current.left != null) {
                    visited.addLast(current.left)
                }
                if (current.right != null) {
                    visited.addLast(current.right)
                }
            }
        }
        println("]")
    }

    override fun levelSizes() {
        var currentDepth = 0
        var nextLevelNodes = 0
        if (root != null) {
            val toVisit = LinkedList<Node>()
            toVisit.push(root)
            while (!toVisit.isEmpty()) {
                val current = toVisit.removeFirst()
                if (current.left != null) {
                    toVisit.addLast(current.left)
                    nextLevelNodes++
                }
                if (current.right != null) {
                    toVisit.addLast(current.right)
                    nextLevelNodes++
                }
                if (nextLevelNodes == toVisit.size) {
                    if (nextLevelNodes != 0) {
                        println("${currentDepth + 1} level contains $nextLevelNodes")
                    }
                    currentDepth++
                    nextLevelNodes = 0
                }
            }
        }
    }

    override fun listLevel(level: Int) {
        if (level == 0) {
            println(listOf(root))
        }
        var currentLevel = 0
        var nextLevelNodes = 0
        if (root != null) {
            val toVisit = LinkedList<Node>()
            toVisit.push(root)
            while (!toVisit.isEmpty()) {
                val current = toVisit.removeFirst()
                if (current.left != null) {
                    toVisit.addLast(current.left)
                    nextLevelNodes++
                }
                if (current.right != null) {
                    toVisit.addLast(current.right)
                    nextLevelNodes++
                }
                if (nextLevelNodes == toVisit.size) {
                    if (level == currentLevel + 1) {
                        println(toVisit)
                    }
                    currentLevel++
                    nextLevelNodes = 0
                }
            }
        }
    }
}