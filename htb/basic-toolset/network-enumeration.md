# Enumeration


---


## Nmap Cheat Sheet

Cheat Sheet

The cheat sheet is a useful command reference for this module.
Scanning Options


|Nmap Option     	|	Description |
|:-:|:-:|
|10.10.10.0/24 		|	Target network range. |
|-sn 				|	Disables port scanning. |
|-Pn 				|	Disables ICMP Echo Requests|
|-n 					|	Disables DNS Resolution.|
|-PE 				|	Performs the ping scan by using ICMP Echo Requests against |
|--packet-trace 		|	Shows all packets sent and received.|
|--reason 			|	Displays the reason for a specific result.|
|--disable-arp-ping 	|	Disables ARP Ping Requests.|
|--top-ports=<num> 	|	Scans the specified top ports that have been defined as |
|-p- 				|	Scan all ports.|
|-p22-110 			|	Scan all ports between 22 and 110.|
|-p22,25 			|	Scans only the specified ports 22 and 25.|
|-F 					|	Scans top 100 ports.|
|-sS 				|	Performs an TCP SYN-Scan.|
|-sA 				|	Performs an TCP ACK-Scan.|
|-sU 				|	Performs an UDP Scan.|
|-sV 				|	Scans the discovered services for their versions.|
|-sC 				|	Perform a Script Scan with scripts that are categorized as |
|--script <script> 	|	Performs a Script Scan by using the specified scripts.|
|-O 					|	Performs an OS Detection Scan to determine the OS of the target|
|-A 					|	Performs OS Detection, Service Detection, and traceroute scans.|
|-D RND:5 			|	Sets the number of random Decoys that will be used to scan the |
|-e 					|	Specifies the network interface that is used for the scan.|
|-S 10.10.10.200 	|	Specifies the source IP address for the scan.|
|-g 					|	Specifies the source port for the scan.|
|--dns-server <ns> 	|	DNS resolution is performed by using a specified name server.|
