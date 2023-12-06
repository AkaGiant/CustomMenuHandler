# Introduction

-----

### THIS IS NOT AN API
I do plan to make a JitPack that you can add as a dependency with bareness however, im not to sure how I will do that seeing as this also uses my
[Configuration System](https://github.com/AkaGiant/ConfigurationHandler) so by importing that, you also get the Configuration System... which you may not want.

### I may have 3 Branches
A JitPack Branch with the Configuration System Included
A JitPack Branch without the Configuration System
and the Main Branch which has all the code, including the examples and docs (these files you are currently reading).

I MAY also release this as an actual plugin, but it is not intended to repalce the likes of Deluxe Menus.

### What is this?

The Code aims to provide myself with a method of creating Dynamic Menus for any
I create now or in the future. Open Sourcing the code I aim to provide other developers
with a base to either work with, use or stay away from. It's up to you at the end of the day.

### Some things to know about this code
<li> It's designed for use cases I feel I run into a lot.
<li>I can give no promises that It will work across different versions of minecraft
<li>This code uses the CommandAPI to handle reloading of commands and registering of
commands. If you choose to use another handler, it's up to you to integrate the reloading
of these commands however you see fit.
<li>All menus are built and managed by the IF API at their core, then this code, uses the IF
API to create dynamic menus.
<li>The code for the Configuration System may not be the same as in my repository for it as I didn't want to import it here, I wanted to allow you to see all the code
I use for Configuration Handling even if it may not be used here exactly.

## Links
- CommandAPI - https://github.com/JorelAli/CommandAPI
- IF API - https://github.com/stefvanschie/IF/
