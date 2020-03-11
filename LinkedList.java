/*
This class uses the class Node
The Node class object has two pieces of information
    The data 
    The next Node's address

This class creates a sorted linked list with any number of elements
This class has 6 methods:
    insert()
    delete()
    get()
    get(index)
    reverse()
    split()

insert():
	if the linked list is empty
		the first node is assigned as the newly created node
		the last node is assigned as the newly created node
	else
		if the new node's value is greater than the first node's
			the new node is assigned as the first node
		else if the new node's value is lesser than the last node's value
			the new node is assigned as the last node
		else 
			the node is created in between the linked list

delete():
	if the index is lesser than 0
		prints "no index found"
	else
		loops while the current node is not null
		if the iteration is equal to the index
				the previous node's next node is assigned as the current node's next node, therein deleting the current node
				the loop is broken
			else if the next node in the linked list is equal to null
				prints "index not available"
				the loop is broken
			else the current nodes is assigned as the next node

get():
	loops while the current node is not equal to null
		prints the current node's data
		assigns the current node as the next node in the linked list
		
get(index):
	if the index is lesser than 0
		prints "no index found"
	else 
		loops while the current node is not null
			if the iteration is equal to the index
				prints the current node's data
				the loop is broken
			else if the next node in the linked list is equal to null
				prints "index not available"
				the loop is broken
			else the current nodes is assigned as the next node

reverse():
	number of nodes is found using a loop
	an array data is created with number of nodes amount of spaces
	data is assigned the linked lists data by iterating till count
	the nth node is assigned to the (length of the array - n)th index of the data array
	
split():
	an index is passed
	the linked list after the index is stored in another linked list
	the newly formed linked list is returned
 */
public class LinkedList {
	Node first, last, curr, prev;

	public void insert(double val) {
		Node newnode = new Node(val);
		if (first == null) {
			first = newnode;
			last = newnode;
		} else {
			if (newnode.data < first.data) {
				newnode.next = first;
				first = newnode;
			} else if (newnode.data > last.data) {
				last.next = newnode;
				last = newnode;
			} else {
				curr = first;
				prev = curr;
				curr = curr.next;
				while (curr != null) {
					if ((newnode.data > prev.data) && (newnode.data < curr.data)) {
						prev.next = newnode;
						newnode.next = curr;
						break;
					} else {
						prev = curr;
						curr = curr.next;
					}
				}
			}
		}
	}

	public void delete(int index) {
		curr = first;
		prev = curr;
		int at = -1;
		if (index < 0) {
			System.out.println("No index found");
		} else {
			while (curr != null) {
				at++;
				if (at == index) {
					prev.next = curr.next;
					break;
				}
				if (curr.next == null) {
					System.out.println("Index not available");
					break;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
		}
	}

	public void get() {
		// returns everything
		curr = first;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public void get(int index) {
		// returns specific data at index "index"
		curr = first;
		int at = -1;
		if (index < 0) {
			System.out.println("No index found");
		} else {
			while (curr != null) {
				at++;
				if (at == index) {
					System.out.println(curr.data);
					break;
				}
				if (curr.next == null) {
					System.out.println("Index not available");
					break;
				} else {
					curr = curr.next;
				}
			}
		}
	}

	public void reverse() {
		// reverses the LinkedList
		curr = first;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		curr = first;
		double[] data = new double[count];
		for (int x = 0; x < count; x++) {
			data[x] = curr.data;
			curr = curr.next;
		}
		curr = first;
		for (int x = count - 1; x >= 0; x--) {
			curr.data = data[x];
			curr = curr.next;
		}
	}

	public LinkedList split(int index) {
		curr = first;
		int count = 0;
		Node keep = new Node(0);
		for (int x = 0; x < index; x++) {
			curr = curr.next;
			keep = curr;
		}
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		curr = keep;
		double[] data = new double[count];
		for (int x = 0; x < count; x++) {
			data[x] = curr.data;
			curr = curr.next;
		}

		LinkedList l = new LinkedList();
		for (int x = 0; x < count; x++) {
			l.insert(data[x]);
		}
		return l;
	}
}