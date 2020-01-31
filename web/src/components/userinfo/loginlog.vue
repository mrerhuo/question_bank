<template>
  <div>
  <Timeline>
        <TimelineItem>
            <p class="time">2019年01月31日</p>
            <p class="content">23点54分</p>
            <p class="content">22点54分</p>
        </TimelineItem>
         <TimelineItem>
            <p class="time">2019年01月30日</p>
            <p class="content">23点54分</p>
            <p class="content">22点54分</p>
        </TimelineItem>
        <TimelineItem>
            <p class="time">2019年01月29日</p>
            <p class="content">23点54分</p>
            <p class="content">22点54分</p>
        </TimelineItem>
        <TimelineItem>
            <p class="time">2019年01月28日</p>
            <p class="content">23点54分</p>
            <p class="content">22点54分</p>
        </TimelineItem>
    </Timeline>
  </div>
</template>
<script>
export default {
  components: {},
  props: {},
  data() {
    return {};
  },
  computed: {},
  mounted() {},
  methods: {},
  created() {},
  watch: {}
};
</script>
<style scoped lang="less">
.time{
        font-size: 14px;
        font-weight: bold;
    }
    .content{
        padding-left: 5px;
    }
</style>