# word-indexer

This java program implements a word indexer using a [binary](https://en.wikipedia.org/wiki/Binary_tree) or an 
[AVL tree](https://en.wikipedia.org/wiki/AVL_tree).

## Description

It reads an input text file and creates a tree where each node is a unique word found in the input text along with all 
the indices where the word occurs in the text. Then the user can input words and the program outputs how many times and 
where each word occurs. The program terminates when the user types the command exit(). The index of a word is the total 
number of characters found in the input file until the beginning of the word. The words are case sensitive.

## Usage

Compilation:

```bash
javac WordIndexer.java
```

Run:

```bash
java WordIndexer <tree_type> <input_file>
```
Where:

| \<tree_type> | Description                               |
| ------------ | ----------------------------------------- |
| -avl         | build a work indexer using an avl tree.   |
| -binary      | build a work indexer using a binary tree. |


<input_file> is a text file.
 
## Examples

```bash
java WordIndexer -binary ..\data\bible.txt

Building the tree...
Total building time: 29.05 seconds.

Search for words in the text by typing a word and pressing the ENTER button (type exit() for terminating the program)

> Athens

Athens found 5 times at indices:
3851166, 3851317, 3852244, 3854045, 4104346,

> Cyprus

Cyprus found 8 times at indices:
3788114, 3822610, 3822717, 3828303, 3843639, 3868573, 3870442, 3896093,

>exit()

Thank you for using my program, Bye!
```

```bash
java WordIndexer -avl ..\data\bible.txt

Building the tree...
Total building time: 33.48 seconds.

Search for words in the text by typing a word and pressing the ENTER button (type exit() for terminating the program)

>Barnabas

Barnabas found 29 times at indices:
3788017, 3812006, 3823039, 3823366, 3824086, 3827603, 3827823, 3828044, 3828681, 3833518
3833872, 3834604, 3836201, 3836458, 3837450, 3838618, 3838708, 3840151, 3841426, 3842012
3843020, 3843160, 3843299, 3843603, 3980643, 4045504, 4046733, 4047285, 4099186,

>Maria
Maria was not found in the input text

>Mary

Mary found 54 times at indices:
3315235, 3315591, 3315987, 3318000, 3369848, 3440613, 3440633, 3441174, 3441204, 3441985
3442014, 3467433, 3523458, 3523478, 3524359, 3524378, 3524465, 3524485, 3525580, 3530334
3530643, 3531043, 3531538, 3531661, 3531891, 3532412, 3533214, 3536137, 3537467, 3537731
3539391, 3570889, 3591115, 3591499, 3662896, 3662927, 3720873, 3720919, 3722660, 3722793
3723556, 3723882, 3724005, 3725567, 3727447, 3760312, 3760343, 3762675, 3763773, 3764530
3764811, 3772645, 3825878, 3955984,

>exit()

Thank you for using my program, Bye!
```
## Author

Giorgos Argyrides (g.aryrides@outlook.com)
