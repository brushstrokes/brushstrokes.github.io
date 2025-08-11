# OS and VM isolation

## Table of Content


* paper review as prerequisite



---

## firecracker: lightweight virtualization for serverless applications

Serverless containers and functions are widely used for deploying and managing software in the cloud. Their popularity is due to reduced cost of operation, improved utilization of hardware, and faster scaling than traditional deployment methods.

The ecoomics and scale of severless applications  demand that workloads from multiple customers run on the same hardware with minimal overhead, while preserving strong security and performance isolation. 

The traditional view is that there is a choice between virtualization with strong security and high overhead, and container techonologies with weaker security and minimal overhead.

This tradeoff is unacceptable to public infrastructure providers, who need both strong security and eminimal overhead. To meet this need, Amazon developed Firecracker, a new open source Virtual Machine Monitor (VMM) specialied for serverless workloads, but generally useful for containers, functions and other compute workloads within a reasonable set of constraints.

Firecracker is deployed in two publically-available serverless comput services at AWS (Lambda and Fargate), where it supports millions of production workloads, and trillions of requests per month.


### definitions to review

- [ ] serverless
- [ ] AWS E2
- [ ] docker
- [ ] LXC
- [ ] control groups (cgroups)
    + provides process grouping
    + resources throttling 
    + accounting
- [ ] namespaces
- [ ] seccomp-bpf
    + provides access 

comparison/competitors of Firecracker

* Kata Containers
* Intel's Clear Containers
* NEC's LightVM

all of these efforts have a shared goal of optimizad Isolation within computer infrastructure and choosing hypervisor-based virtualization as a way to achieve that. QEMU/KVM has been the base for the majority of these projects. 

Firecracker is probably most notable for what it does not offer, especially compared to QEMU. It does not offer a BIOS, cannot boot arbitrary kernels, does not emulate legacy devices nor PCI, and does not support VM migration.

###  



---


Operating systems and virtual machines have been the workhorses of isolation for a long time. One baseline isolation plan, which we don't have a reading assignment for, is to rely on the operating system to isolate processes / users / containers from one another; you have hopefully seen it in previous classes (such as 6.1800), and we will talk a bit about it in lecture. 

## Preparation

There are three readings associated with this lecture. Those being on gVisor, Firecracker, and the comparison of the two.





---