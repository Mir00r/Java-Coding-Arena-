1. Multithreading Basic Terminology 
	
	i) Process
		-> Running state of an more application.
		-> Consist of one or more threds.
		-> Has own virtual address space.
	
	ii) Thread
		-> Lightweight process.
		-> Resides in the same address space of a process.
		-> Threads of a process shares resources and address space among themselves.
	
	iii) Task Scheduling 
		-> Algorithm that operating system as well as the processor uses to distribute CPU
			time among multiple processes and threads.
		
	iv) Contex Switching 
		-> Mechanism of storing and restoring the context or state of a process and/or thread.
		
		
2. Multithreading and Concurrency
	
	i) Why multithreading?
		-> Maintain responsiveness of an application (e.g blocking operations).
		-> Fully utilize system resources.
		-> Some tasks are meant to be parallelized.
		
		
3. Thread Lifecycle 

	i) Lifecycle States
		-> New : Thread object has been created but not initialize yet.
		-> Runnable : Thread is ready to run.
		-> Waiting : Thread could be run but currently not in a runnable state.
		-> Terminated : A runnable thread enters the terminated state when it completes 
						its task or othewise terminates.
						
						
4. Multithreading Limitations and Pitfalls

	i) Limitations
		-> Systems that require processing aren't suitable for multithreading.
		-> Coding, debugging and testing is often difficult and sophisticated 
			in a multithreading system.
			
	ii) Resource sharing in multithreaded environment 
		-> Remember threads share the same address space within a process?
			-->> What if multiple threads try to access a shared resource?
		-> A thread may not have finished processing a shared resource
			-->> An interrupt may send it to waiting state (even though it's not done)
			-->> Meanwhile another thread accessing the same data structure for another operation.
			
	iii) Race Condition Solution
		-> Make all the methods that access the shared resource synchronized
			-->> Uses a locking mechanism.
			-->> A thread needs to acquire a lock before accessing the shared resources.
			-->> Free the resource lock upon completion.
			-->> Much like public telephone booths.
			

5. Multithreading in Application

	i) Producer-consumer problem 
		-> Classic multithreading application.
		-> Also known as Bounded-buffer problem.
		-> Two entities (e.g producer and consumer ) will perform operations on a fixed-size
			shared buffer.
		-> The buffer is a Queue ( FIFO )
		-> Producer produces products and stores into the buffer ( hence, occupies memory in buffer )
			-->> If buffer gets full, producer waits.
		-> Consumer consumes products from buffer ( hence, fees buffer memory )
			-->> If the buffer is empty, consumer waits.
			
	ii) Critical Operation
		-> Buffer writing / consuming. 
		-> Must be synchronized.
