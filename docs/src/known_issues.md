# Known Issues

-----

## Paper Async Command Builder Thread Pool - 0
The following may be thrown when using the CommandAPI (9.2) + Paper please reference
https://github.com/JorelAli/CommandAPI/pull/501 for more information.
as for my testing, i haven't noticed any actual issues arise due to this.
```
java.util.ConcurrentModificationException: null
        at java.util.TreeMap$PrivateEntryIterator.nextEntry(TreeMap.java:1486) ~[?:?]
        at java.util.TreeMap$ValueIterator.next(TreeMap.java:1531) ~[?:?]
        at net.minecraft.commands.Commands.fillUsableCommands(Commands.java:483) ~[?:?]
        at net.minecraft.commands.Commands.sendAsync(Commands.java:443) ~[?:?]
        at net.minecraft.commands.Commands.lambda$sendCommands$5(Commands.java:422) ~[?:?]
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136) ~[?:?]
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635) ~[?:?]
        at java.lang.Thread.run(Thread.java:833) ~[?:?]
```

