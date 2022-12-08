
class Four12 {
    fun countPathsWithSum(node: TreeNode?, targetSum: Int): Int {
        return countPathsWithSum(node, targetSum, 0, hashMapOf<Int, Int>())
    }

    private fun countPathsWithSum(node: TreeNode?, targetSum: Int, runningSum: Int, pathCount: HashMap<Int, Int>): Int {
        if (node == null) {
            return 0
        }
        var innerRunningSum = runningSum + node.`val`
        var sum = innerRunningSum - targetSum
        var totalPaths = pathCount.getOrDefault(sum, 0)
        if (innerRunningSum == targetSum) {
            totalPaths ++
        }

        incrementHashTable(pathCount, innerRunningSum, 1)
        totalPaths += countPathsWithSum(node.left, targetSum, innerRunningSum, pathCount)
        totalPaths += countPathsWithSum(node.right, targetSum, innerRunningSum, pathCount)
        incrementHashTable(pathCount, innerRunningSum, -1)
        return totalPaths
    }

    private fun incrementHashTable(hashTable: HashMap<Int, Int>, key: Int, delta: Int) {
        val newCount = hashTable.getOrDefault(key, 0) + delta
        if (newCount == 0) {
            hashTable.remove(key)
        } else {
            hashTable[key] = newCount
        }
        println("$hashTable")
    }

    fun createTestNode(): TreeNode {
        val one = TreeNode(10)
        val two = TreeNode(5)
        val three = TreeNode(-3)
        val four = TreeNode(3)
        val five = TreeNode(1)
        val six = TreeNode(11)
        val seven = TreeNode(3)
        val eight = TreeNode(-2)
        val night = TreeNode(2)

        one.left = two
        one.right = three
        two.left = four
        two.right = five
        three.right = six
        four.left = seven
        four.right = eight
        five.right = night
        return one
    }
}