class Program {
  public static LinkedList findLoop(LinkedList head) {
    LinkedList pointerOne = head.next;
    LinkedList pointerTwo = head.next.next;

    while(!Objects.equals(pointerOne, pointerTwo)){
      pointerOne = pointerOne.next;
      pointerTwo = pointerTwo.next.next;
    }

    pointerTwo = head;

    while(!Objects.equals(pointerOne, pointerTwo)){
      pointerOne = pointerOne.next;
      pointerTwo = pointerTwo.next;
    }

    return pointerOne;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
