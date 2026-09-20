package org.zdanek.javabasic.generics.classes.and.interfaces;


public class SortedPairTest
{

    public void shouldRetainOrderOfOrderedPair()
    {
        SortedPair<Integer> pair = new SortedPair<>(1, 2);

        /*//assertEquals(1, pair.getFirst().intValue());
        //assertEquals(2, pair.getSecond().intValue());*/
    }

    public void shouldFlipOrderOfMisorderedPair()
    {
        SortedPair<Integer> pair = new SortedPair<>(2, 1);

        /*//assertEquals(1, pair.getFirst().intValue());
        //assertEquals(2, pair.getSecond().intValue());*/
    }

}
