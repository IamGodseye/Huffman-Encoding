

# **Huffman-Encoding**
Huffman-Encoding:
> Huffman encoding is a particular type of optimal prefix code that is commonly used for lossless data compression.

Wikipedia: https://en.wikipedia.org/wiki/Huffman_coding


*How to use the project-code:*
1. Clone the repository.
2. Open the source-code in Eclipse or any IDE.
3. Make a package and add all the source-code in that.
4. Run the Huffman_Client.java....... Boom, It's working.

*How it works:*
1. First of all take the input string. 

2. Make frequency map for that string.

3. For each key in the map, now you need to create a Node & insert that node in a min Heap (here implemented using Priority Queue).
[Node=> char character, int frequency, Node left_node, Node right_node]

4. Iterate whole queue, take 2 Node, combine them and push them in the queue. 

5. Do 4th step until we are left with single Node.

6. Take the last node and parse that node to fill encoder and decoder Hash maps.
while parsing the node if we are going in the left node add 0 and in right add 1.

-  For more understanding refer to this: https://www.youtube.com/watch?v=uDS8AkTAcIU&t=566s
