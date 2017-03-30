
public class LinkList {
	class node {
		int item;
		node next;
	}
	node head;
	/**
	 * Something Is Wrong With my Add Function...
	 * @param x
	 */
	public void addItem (int x){
	
		node newNode = new node ();
		newNode.item = x;
		// If there's nothing inside of the link list
		// Make bother the head and tail equal to the first one
		if (head == null){
			head = newNode;
		}else{  // OtherWise, link the last element of head to newNode 
				// And make tail the newest element that came in
			node copy = head;
			while (copy.next != null){
				copy = copy.next;
			}
			copy.next = newNode;
		}
	}
	
	public void PrintAll (){
		int counter = 0;
		node top = head;
		// How Do I prevent the last one from showing a plus sign
		while (top != null){
			if(top.next != null){
				System.out.print(top.item + "x ^ " + counter + " + " );
			}else{
				System.out.print(top.item + "x ^ " + counter );
			}
				top = top.next;
				counter++;
		}
		System.out.print("\n\n");
	}
	
	/**
	 * Add Polynomials together...
	 * @param otherList
	 * @return
	 */
	public LinkList addPoly (LinkList otherList){
		LinkList newList = new LinkList ();
		node List1 = head; // <-- (1,1,1)
		node  List2= otherList.head; // <-- (1,1)
		while (List1 != null || List2!= null){
			if (List1 == null || List2 == null){
				while (List1 != null){
					newList.addItem(List1.item);
					List1 = List1.next;
				}
				while (List2 != null){
					newList.addItem(List2.item);
					List2 = List2.next;
				}
			}
			else{
				newList.addItem(List1.item + List2.item);
				List1 = List1.next;
				List2 = List2.next;
			}
		}
		return newList;
	}
	/**
	 * 1+n+n^2
	 * *
	 * n^2
	 * 
	 * 
	 * @param otherList
	 */
	public LinkList multiPoly (LinkList otherList){
		LinkList newList = new LinkList ();
		// First I will multiply the first column
		
		node List1 = head;  // <-- array1
		node List2 = otherList.head; // < -- array2
		
		while (List2 != null){
			newList.addItem(List1.item * List2.item);
			List2 = List2.next;
		}
		
		
		int counter = 1;
		List1 = head.next;
		
		while (List1 != null){
			LinkList tempList = new LinkList ();
			List2 = otherList.head;
			int copyCounter = counter;
			
			// add the Zero's to the Beginning of the List.
			while (copyCounter >0){
				tempList.addItem(0);
				copyCounter--;
			}
			
			while (List2 != null){
				tempList.addItem(List1.item*List2.item);
				List2 = List2.next;
			}		
			newList = tempList.addPoly(newList);
			counter++;
			List1 = List1.next;

		}

		return newList;
	}
	
	
	
}
